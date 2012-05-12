<%-- 
    Document   : addBet
    Created on : 12-abr-2012, 14:53:48
    Author     : eddytrex
--%>

<%@page import="segana.Encuentro"%>
<%@page import="java.util.List"%>
<%@page import="logic.TorneoD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Se Gana gambling site</title>
<meta name="keywords" content="platinum, web design theme, free templates, website templates, CSS, HTML" />
<meta name="description" content="Platinum Theme is a free CSS template provided by templatemo.com" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />

<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>
    </head>
    <%
        //String x = request.getParameter("email");
        String username=(String) session.getAttribute("namen");
        
        if(username!=null)
        {
            out.println("<p style=\"text-align:center;\"><a href=\"#\" >"+ username +"</a> , <a href=\"logout.jsp\" >Logout</a></p> ");
            
       }
        if(username==null)
        {
            response.sendRedirect("index.jsp");
        }
    %>
    <body>
       
        <div id="templatemo_wrapper">

            <div id="templatemo_header">
                <div id="site_title"><h1><a href="index.jsp">Se Gana</a></h1></div>
                <div id="templatemo_menu" class="ddsmoothmenu">
                    <ul>
                        <li><a href="index.html" class="selected"><span></span>Home</a></li>
                        <li><a href="about.html"><span></span>Play</a>
                            <ul>
                                <li><a href="submenupage.html">For Virtual Money</a></li>
                                <li><a href="submenupage.html">For Real Money</a></li>                                
                            </ul>
                        </li>                        
                        <li><a href="blog.html"><span></span>Login</a>
                            <ul>
                                    <li><a href="login.jsp">Sign in (Have account)</a></li>
                                    <li><a href="register.jsp">Sign up (Create account)</a></li>                                
                            </ul>
                        </li>
                        <li><a href="portfolio.html"><span></span>About Us</a>
                            <ul>
                                <li><a href="submenupage.html">About "Se Gana"</a></li>
                                <li><a href="submenupage.html">About Developers</a></li>                                
                        </ul>
                        </li>
                        <li><a href="contact.html"><span></span>Contact</a>
                            <ul>
                                    <li><a href="submenupage.html">IRC Channel</a></li>
                                    <li><a href="submenupage.html">Via Email</a></li>                                
                            </ul>
                        </li>
                    </ul>
                    <br style="clear: left" />
                </div> <!-- end of menu -->
            </div> <!-- end of header -->

            <div id="templatemo_middle">                                       
                        <center><p><h2>Welcome, Please select an Area to Bet</h2></p></center>
                    
                    <form name="addc" action="addBet" method="POST">
                        <center>
                        <table border="1">
                           
                            <!--  aqui va la tabla de datos    -->
                            
                            <tbody>
                                <tr>
                                    <td><center><h5>Apuesta Mundial</h5></center></td>
                                    <td><center><h5>Apuesta Europa</h5></center></td>
                                    <td><center><h5>Apuesta Africa</h5></center></td>
                                    <td><center><h5>Apuesta America</h5></center></td>
                                    <td><center><h5>Australia</h5></center></td>
                                </tr>         
                                <tr>
                                   <!-- <td>Numero De Tarjeta</td>
                                    <td><input type="text" name="notarjeta" value="" size="40" /></td>-->
                                   <td>
                                       <a href="world.jsp"><img src="images/world.jpg" width="200" height="200" alt="world"/>                               
                                       </a>
                                   </td>
                                   <td>
                                       <a href="europe.jsp"><img src="images/europa.jpg" width="200" height="200" alt="europe"/>
                                       </a>
                                   </td>
                                   <td>
                                       <a href="africa.jsp"><img src="images/africa.jpg" width="200" height="200" alt="Africa"/>                               
                                       </a>
                                   </td>
                                   <td>
                                       <a href="america.jsp"><img src="images/america.png" width="200" height="200" alt="America"/>                               
                                       </a>
                                   </td>
                                   <td>
                                       <a href="australia.jsp"><img src="images/australia.png" width="200" height="200" alt="Australia"/>                               
                                       </a>
                                   </td>
                                </tr>                                                    
                                                                         
                            </tbody>
                        </table>      
                        </center>
                    </form>
                    
                
                
                    <script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
                    <script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
                    <script type="text/javascript">
                    $(window).load(function() {
                        $('#slider').nivoSlider();
                    });
                    </script>
                <div class="cleaner"></div>
            </div> <!-- end of middle -->

                <div id="templatemo_main_wrapper">
                <div id="templatemo_main">
                        
                </div> <!-- end of main -->
            </div> <!-- end of main wrapper -->

        </div> <!-- end of wrapper -->

        <div id="templatemo_footer_wrapper">
                
               
            
        </div>

        </body>
</html>
