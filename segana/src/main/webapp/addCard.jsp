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
                <div id="templatemo_middle_left">
                        <h2><strong>Se gana Login</strong></h2>
                    <p>You can create a login account here, or login with your account.</p>
                    
                    <form name="addc" action="addcard" method="POST"><table border="0">
                            <tbody>
                                <tr>
                                    <td>Numero De Tarjeta</td>
                                    <td><input type="text" name="notarjeta" value="" size="40" /></td>
                                </tr>
                                
                                <tr>
                                    <td>Tipo de Tarjeta </td>
                                 </tr>   
                                 <tr>
                                    <td> <input type="radio" style="left: 709px" name="typeCard" value="Visa">  Visa </td>
                                  </tr>
                                  <tr>
                                    <td> <input type="radio" style="left: 709px" name="typeCard" value="MCard"> Master Card </td>
                                  <tr>
                                    <td> <input type="radio" style="left: 709px" name="typeCard" value="AExpress">  American Expres </td>
                                </tr>
                                
                                <tr>
                                    <td>Fecha de expiración </td>
                                    <td>Year
                        <%                
                            out.println(" <select name=\"anio\">");
                            int t =2012;
                            for(int m = 0; m < 10; m++)
                            {
                                out.println("<option>"+t+"</option>");
                                t++;
                            }
                            out.println("</select> ");
                        %>
                        Month
                        <%                
                            out.println("<select name=\"mes\">");
                            int z = 1;
                            for(int m = 0; m < 12; m++)
                            {
                                out.println(" <option>"+z+"</option>");
                                z++;
                            }
                            out.println("</select> ");
                        %>                        
                        
                         </td>
                         <td><input type="hidden" name="username" value=<% out.println(username);%>> </td>
                                    <td>
                                        <input type="submit" value="Agregar " name="addCard" />
                                    </td>
                                                    
                            </tbody>
                        </table>                                                
                    </form>
                    
                </div>
                <div id="slider-wrapper">

                    <div id="slider" class="nivoSlider">
                        <img src="images/slider/01.jpg" alt="Slider 01" />
                        <img src="images/slider/02.jpg" alt="Slider 02" />
                        <img src="images/slider/03.jpg" alt="Slider 03" />
                        <img src="images/slider/04.jpg" alt="Slider 04" />
                        <img src="images/slider/05.jpg" alt="Slider 05" />                        
                        <img src="images/slider/06.jpg" alt="Slider 06" />
                        <img src="images/slider/07.jpg" alt="Slider 07" />
                        <img src="images/slider/08.jpg" alt="Slider 08" />
                        <img src="images/slider/09.jpg" alt="Slider 09" />
                        <img src="images/slider/10.jpg" alt="Slider 10" />
                        <img src="images/slider/11.jpg" alt="Slider 11" />
                        <img src="images/slider/12.jpg" alt="Slider 12" />                        
                        <img src="images/slider/14.jpg" alt="Slider 14" />
                        <img src="images/slider/15.jpg" alt="Slider 15" />
                        <img src="images/slider/16.jpg" alt="Slider 16" />
                    </div>

                </div>
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
