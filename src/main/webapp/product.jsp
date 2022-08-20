<!DOCTYPE html>
<html>
   <head>
      <!-- Basic -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
      <title>Add Product</title>
   </head>
   <body class="sub_page">
      <%
         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

         //Validate login page before accessing product.jsp page
         if (session.getAttribute("uname") == null) {
            response.sendRedirect("signin.jsp");
         }
      %>

      <section class="vh-100" style="background-color: #9A616D;">
         <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
               <div class="col col-xl-10">
                  <div class="card" style="border-radius: 1rem;">
                     <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                           <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                                alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                           <div class="card-body p-4 p-lg-5 text-black">

                              <form form _lpchecked="1" action="AddProduct" method="post">

                                 <div class="d-flex align-items-center mb-3 pb-1">
                                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                    <span class="h1 fw-bold mb-0">Add Product</span>
                                 </div>

                                 <div class="form-outline mb-2">
                                    <label>Enter Id</label> <input class="form-control form-control-lg" type="number" name="id" required />
                                 </div>
                                 <div class="form-outline mb-2">
                                    <label>Enter Name</label> <input class="form-control form-control-lg" type="text" name="pname" required />
                                 </div>
                                 <select class="form-control" name="status" required>
                                    <option>Active</option>
                                    <option>In-Active</option>
                                 </select>
                                 <div class="form-outline mb-2">
                                    <label>Image Name</label> <input class="form-control form-control-lg" type="text" name="imagename" required />
                                 </div>
                                 <div class="form-outline mb-4">
                                    <label>Price</label> <input class="form-control form-control-lg" type="number" name="price" required/>
                                 </div>
                                 <div class="form-outline mb-4">
                                    <label>Quantity</label> <input class="form-control form-control-lg" type="number" name="qty" required/>
                                 </div>
                                 <div class="pt-1 mb-4">
                                    <label>Product Category</label> <input class="form-control" type="text" name="category" required/>
                                 </div>
                                 <div class="pt-1 mb-4">
                                    <label>Attach Product Image</label> <input type="file" name="attachimage" required/>
                                 </div>
                                 <%
                                    String msg = request.getParameter("msg");

                                    if ("valid".equals(msg)) {%>
                                       <h2>Product added successfully</h2>
                                    <%}%>
                                 <%
                                    if ("invalid".equals(msg)) { %>
                                 <h2>Sorry, something went wrong</h2>
                                 <%}%>


                                 <button type="submit" value="addProduct" class="btn btn-success" onclick="return confirm('Are you sure Do you want to add this product?');">Add Product</button>
                                 <button type="reset" class="btn btn-danger">Reset</button>


                              </form>

                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
   </body>
</html>