<?php 
  namespace App\Controller;
   
  
 use Symfony\Component\HttpFoundation\Request;
 use Symfony\Component\HttpFoundation\Response;
 use Symfony\Component\Routing\Annotation\Route;
 use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
 use Symfony\Bundle\FrameworkBundle\Controller\Controller;

 class FinanceController extends DefaultController {
      
      
       /**
        * @Route("/finance" ,name = "finanace_view")
        * @Method({"GET"})
        */
        public function finance()
        {
          
          if(!isset($this->session) || $this->session->get('islogin') === false ||  !($this->session->get('designation') == "finance"))
            return $this->redirectToRoute('root');
          
          $eid = $this->session->get('empid');
          $get_data =   $this->curlApi->callAPI('GET', 'localhost:8080/login/'.$eid , false);
          $emp = json_decode($get_data, true); 

           $get_data = $this->curlApi->callAPI('GET', 'localhost:8080/Forms/Finance', false);
           $response = json_decode($get_data, true);
           
            
           return $this->render('views/financeView.html.twig', array(

             "result" => $response,
             "emp"   => $emp
          ));
        }


        



  }

  ?>

