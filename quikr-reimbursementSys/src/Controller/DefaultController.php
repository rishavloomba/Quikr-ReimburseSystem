<?php
    namespace App\Controller;
    ob_start();
    use Symfony\Bundle\FrameworkBundle\Controller\Controller;
    use Symfony\Component\HttpFoundation\Session\Session;

    class DefaultController extends Controller {
        protected $session;
        protected $curlApi;

        public function __construct() {
            $this->curlApi = new CurlApiRequest();
            $this->session =  new Session();
            $this->session->start();
        }

    }
?>