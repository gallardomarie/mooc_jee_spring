<!DOCTYPE html>
<%@ page import="web.Bag" %>
<html>
  <body>
    <h1>sac</h1>
    <%
    Bag bag = (Bag) session.getAttribute("bag");
		try{
			bag.print(out);
		}
		catch (Exception e){
			out.println("Le panier est vide");
		}
    %>
    <form action='bag' method='post'>
		Reference <input name='ref'><p>
		Quantity <input name='qty'><p>
		<input type='submit' value='Ajouter ce produit au panier'/>
		</form>
  </body>
</html>
