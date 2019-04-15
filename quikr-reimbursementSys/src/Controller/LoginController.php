<?php
 
   namespace App\Controller;
  
   use Symfony\Component\HttpFoundation\Request;
   use Symfony\Component\HttpFoundation\Response;
   use Symfony\Component\Routing\Annotation\Route;
   use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
   use Symfony\Bundle\FrameworkBundle\Controller\Controller;
   use Symfony\Component\HttpFoundation\Session\Session;
   
   
   class LoginController extends DefaultController {


        public function __construct() {
            parent::__construct();
        }
       
        /**
         *  @Route("/" , name="root")
         *  @Method({"GET"})
         */
        public function index() {

        
            return $this->render('/views/login.html.twig');
        }

        /**
         * @Route("/login")
         * @Method({"POST"})
         */
        public function login(Request $request) {


            

            //Fetching data from Request
            $data = $request->request->all();
          
          
            // Check is there data exist or not
           if( $data ) {
                //Fetch fro Api
               
                
                $get_data = $this->curlApi->callAPI('GET', 'localhost:8080/login/'.$data['id'], false);
                $user = json_decode($get_data, true);
            
                //print_r($user); die();
                // Validating Users
                if( $user  && $user['password'] == $data['password']) {
                    //$this->session->start();
                    $this->session->set('islogin' , true);
                    $this->session->set('empid' , $user['empid']);
                    $this->session->set('designation' , $user['designation']);
                return $this->redirectToRoute('reimbursemet_sys');
                
                } else {
                    $this->addFlash(
                        "msg" ,
                        'inavalid Creadentials!!'
                    );
                    return $this->redirectToRoute('root');
                }
           } else {
               return $this->redirectToRoute('root');
           }

            
            
           
             
         }
        


    }

?>
