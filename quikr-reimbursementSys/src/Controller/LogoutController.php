<?php
  
  namespace App\Controller;
  
  use Symfony\Component\HttpFoundation\Response;
  use Symfony\Component\Routing\Annotation\Route;
  use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
  use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class LogoutController extends DefaultController {

    /**
     * @Route("/logout")
     * @Method({"GET"})
     */
    public function logout()
    {
        $this->session->set('islogin' , false);
        $this->session->clear();
        ob_flush();
        return $this->redirectToRoute('root');
    }
 }
?>