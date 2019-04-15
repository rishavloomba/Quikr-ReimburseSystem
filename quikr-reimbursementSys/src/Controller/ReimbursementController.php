<?php
   namespace App\Controller;
   
  
   use Symfony\Component\HttpFoundation\Request;
   use Symfony\Component\HttpFoundation\Response;
   use Symfony\Component\Routing\Annotation\Route;
   use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
   use Symfony\Bundle\FrameworkBundle\Controller\Controller;
   

   class ReimbursementController extends DefaultController {

     /**
      *  @Route("/reimbursement", name="reimbursemet_sys")
      *  @Method({"GET"})
      */
     public function reimbursement() {
           
        // Checking Authentication 
        if(!isset($this->session) || ($this->session->get('islogin') == NULL)) {
            $this->addFlash(
                'msg' , 
                 'Please Login!!'
               );
             return $this->redirectToRoute('root');
          }
             

         $eid = $this->session->get('empid');
         $get_data =   $this->curlApi->callAPI('GET', 'localhost:8080/login/'.$eid , false);
         $emp = json_decode($get_data, true); 

         // Sending Body request
          $data = array(
                  "id" => $this->session->get('empid'),
                  "tofetch" => "all"

              );
           
          $urlString = 'localhost:8080/Forms';
          $get_data = $this->curlApi->callAPI('GET', $urlString , json_encode($data));
          $response = json_decode($get_data, true);
          
          // Key 
          $key =  array_keys($response);


          // Fetching task data  
          $final=array();
           $c = 0;
            foreach($key as $k) {
              foreach($response[$k] as $d ) {
                  $final[$k][] = $d['tasks'];
               }
              $c++;
           }
 


              // Fetching status
             $st = array();

             foreach($key as $k) {
              foreach($response[$k] as $d ) {
                  $st[$k] = $d['status'];
                     
               }
             }
      

            return $this->render('views/reimbursement.html.twig', array(
              "status" => $st,
               "key"  =>  $key,
                "result" => $final,
                "emp"   => $emp
            ));
        }

     
     

        //=======================================
       // Published Expense
      //========================================        
      /**
       * @Route("reimbursement/publish/{tid}" , name="publishing")
       * @Method({"GET"})
       */
       public function publishedExp($tid) {
        
             // Checking Authentication 
           if(!isset($this->session) || ($this->session->get('islogin') == NULL)) {
             return $this->redirectToRoute('root');
           }
             
            $data = array(
                "id" => $this->session->get('empid'),
                "topublish" => [$tid]
            );
            $urlString = 'localhost:8080/tasks/emp/publish';
            $get_data = $this->curlApi->callAPI('POST', $urlString,  json_encode($data));
            
            return $this->redirectToRoute('reimbursemet_sys');
           
        }

        //========================
        //  Tasks Add Form
        //========================
        /**
         * @Route("/reimbursement/new" , name="new_reimbursement")
         * @Method({"GET"})
         */
        public function addNewReimbursement() {

            return $this->render("/views/addNewExpense.html.twig");
        }



        //============================
        //   add expense form 
        //============================
        /**
         *  @Route("/reimbursement/addexpense" , name="add_reimbursement")
         *  @Method({"POST"})
         */
        public function addNewReimbursementData(Request $request) {

          
          // User detail
          $eid = $this->session->get('empid');
          $get_data =   $this->curlApi->callAPI('GET', 'localhost:8080/login/'.$eid , false);
          $emp = json_decode($get_data, true);

          // Fetch body from Request
          $raw = $request->request->all();
          
          if(!isset($raw['disc']) ) {
            $this->addFlash(
              'ins' , 
               'No Expense is Inserted!'
             );

             return $this->redirectToRoute('reimbursemet_sys');
          }
        

           // size of row
           $totalExp =0;
           $data = []; 
            $size = sizeof($raw['date']);
        // Grouping tasks   
        for($i = 0 ; $i < $size ; $i++){
        
            
          $total = $raw["travel"][$i] + $raw['hotel'][$i]+ $raw['buisness'][$i]+$raw['telephone'][$i];
              $d =  array(
                   "expense_date"  => $raw['date'][$i],
                   "travel_exp"    => $raw['travel'][$i],
                  "telephone_exp"  => $raw['telephone'][$i],
                   "hotel_stay"    => $raw['hotel'][$i],
                   "business_meal" => $raw['buisness'][$i],
                   "description"   => $raw['disc'][$i],
                   "total_exp"     => $total
              );

                $totalExp = $totalExp + $total;
                $data[$i] = $d ;
             
          }
          $final = array( 
            "empid"      => $emp['empid'],
            "managerid"  => $emp['mngId'],
            "tasks"      => $data,
            "total_exp"  => $totalExp
        );
          
        $get_data =  $this->curlApi->callAPI('POST', 'localhost:8080/Forms/AddForm' , json_encode($final));
        

        return $this->redirectToRoute('reimbursemet_sys');
        }

   }

 ?>  