<form id="form_PayBy" action="{$PayBy_URL_PayBy}" method="post" name="form_PayBy">

<input type="hidden"  name="ORDER_ID" value="{$ORDER_ID}"/>
<input type="hidden"  name="REFERENCE_ID" value="{$REFERENCE_ID}"/>
<input type="hidden"  name="TRACK_ID" value="{$TRACK_ID}"/>

</form>
 <script language="javascript">
       document.getElementById("form_PayBy").submit();
</script>
<div class="addresses-lists">
	<ul class="myaccount-link-list">
		<li style="list-style: outside none none;">
			<a href="javascript:document.form_PayBy.submit();" title="Continuer votre paiement via PayBy" style=" background: none repeat scroll 0 0 #f5f5f5;     border-color: #dddddd;     border-radius: 4px;     border-style: none none solid;     border-width: medium medium 3px;     display: block;     overflow: hidden;     position: relative;     text-decoration: none;">
				<i style="margin-left: 10px; margin-right: 10px; color: rgb(119, 119, 119); font-size: 20px; text-align: center; width: 50px; position: absolute; top: 10px;">
					<img width="50" src="modules/PayBy/logos/PayBy.png">
				</i>
					<span style="display: block; font-size: 14px; font-weight: bold; overflow: hidden; color: rgb(119, 119, 119); margin-left: 66px; padding: 10px 0px;"> Votre demande de paiement est en cours de traitement. Merci de ne pas rafraîchir la page. </br> Si vous n'êtes pas redirigés automatiquement, veillez cliquer sur ce lien  </span>
			</a>
		</li>
	</ul>
</div>