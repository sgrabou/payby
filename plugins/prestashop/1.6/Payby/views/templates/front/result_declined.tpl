<style>
  div.resultat_paiement {
    max-width: 600px;
    border: 1px solid #e5e5e5;
    padding: 20px 20px;
    margin: 15px auto;
    font-family: Arial, Helvetica, sans-serif;
  }

  div.resultat_paiement h4 {
    text-align: center!important;
    padding: 15px!important;
    margin: 0px 0px 15px 0px!important;
  }

  div.resultat_paiement.succee h4 {
    background-color: #cfc;
    color: #49a71a;
  }

  div.resultat_paiement.error h4 {
    background-color: #fdb5b5;
    color: #be1414;
  }

  div.resultat_paiement p {
    text-align: center!important;
    color: #666666!important;
    font-size: 16px;
    margin-bottom: 15px;
    margin-top: 0px;
  }

  div.resultat_paiement span.numero {
    text-align: center!important;
    display: block;
    margin-bottom: 15px;
    font-weight: bold;
    font-size: 17px;
    color: #666666!important;
  }

  div.resultat_paiement a {
    color: #375caa;
    font-size: 17px;
    font-weight: 700;
  }

  div.resultat_paiement.succee p.m-b-0 {
    margin-bottom: 0px!important;
  }
</style>

<div class="resultat_paiement error">
  <h4>Paiement refusé</h4>
  <span class="numero">Votre commande a échoué.</span>
  <p>Accéder à votre <a href="{$link->getPageLink('order', true)|escape:'html':'UTF-8'}" title="panier">panier</a> pour continuer vos achats</p>
</div>
<!-- End Result Paiement-->
