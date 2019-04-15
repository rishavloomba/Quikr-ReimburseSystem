<?php 
 namespace App\Controller;
   
  
 use Symfony\Component\HttpFoundation\Request;
 use Symfony\Component\HttpFoundation\Response;
 use Symfony\Component\Routing\Annotation\Route;
 use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
 use Symfony\Bundle\FrameworkBundle\Controller\Controller;

 class ManagerController extends DefaultController {
      

       /**
        * @Route("/manager", name="manager_view")
        * @Method({"GET"})
        */
        public function managerView() {

            if( !$this->session &&  !$this->session->get('islogin'))
                return $this->redirectToRoute('root'); 

            
                $eid = $this->session->get('empid');
                $get_data =   $this->curlApi->callAPI('GET', 'localhost:8080/login/'.$eid , false);
                $emp = json_decode($get_data, true); 
    
    
    
                  $data = array(
                      "managerid" => $this->session->get('empid'),
                      "tofetch" => "all",
                      "month" => 0,
                      "year" => 0
    
                  );
               
                $urlString = 'localhost:8080/Forms/Manager';
                $get_data = $this->curlApi->callAPI('GET', $urlString , json_encode($data));
                $response = json_decode($get_data, true);
             
                
              return $this->render("/views/managerViewNew.html.twig",array(
                //"result" => $response,
                 "result" => $response,
                 "emp"   => $emp
              ));
              
        }

        /**
         * @Route("/manager/approve/{tid}" ,name="approved")
         * @Method({"GET"})
         */
        public function approvedStatus($tid)
        {
             if(!$this->session && !$this->session->get('islogin'))
                return $this->redirectToRoute('root');
              $data = array(
                  "managerid"=>$this->session->get('empid'),
                   "formid" => $tid,
                   "status"=>"approved"
            );

            $url='localhost:8080/Forms/Manager/UpdateForm';
            $get_req = $this->curlApi->callAPI('PUT',$url,json_encode($data));
            
            return $this->redirectToRoute('manager_view');
        }

        /**
         * @Route("/manager/{tid}/reject" ,name="reject")
         * @Method({"GET"})
         */
        public function rejected($tid)
        {
           if(!$this->session && !$this->session->get('islogin'))
                return $this->redirectToRoute('root');
                
                $data = array(
                "managerid"=>$this->session->get('empid'),
                "formid" =>$tid,
               "status"=>"rejected"
            );

            $url='localhost:8080/Forms/Manager/UpdateForm';
            $get_req = $this->curlApi->callAPI('PUT',$url,json_encode($data));
            return $this->redirectToRoute('manager_view');
        }


        /**
         * @Route("/manager/filter", name="manager_filter")
         * @Method({"POST"})
         */
        public function managerFilter(Request $request) {

          if( !$this->session &&  !$this->session->get('islogin'))
          return $this->redirectToRoute('root'); 

      
          $eid = $this->session->get('empid');
          $get_data =   $this->curlApi->callAPI('GET', 'localhost:8080/login/'.$eid , false);
          $emp = json_decode($get_data, true); 


           $d = array_merge(array( "managerid" => $eid) , $request->request->all());
           
           $url = 'localhost:8080/Forms/Manager';
           $get = $this->curlApi->callAPI('GET' , $url , json_encode($d));
           $response = json_decode($get , true);

            return $this->render("/views/managerViewNew.html.twig",array(
             "result" => $response,
             "emp"   => $emp
          ));

        }

    }
?>