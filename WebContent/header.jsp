<!-- A grey horizontal navbar that becomes vertical on small screens -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<div class="container">
  <!-- Links -->
  <ul class="navbar-nav">
  	<li><a class="navbar-brand" href="index.jsp">Assetware</a></li>
  	<li class="nav-item">
      <a class="nav-link" href="./upload.jsp">Upload</a>
    </li>
    
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#"  data-toggle="dropdown">
        Asset
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="./SearchAssetLoader?searchType=simple">Search Asset</a>
        <a class="dropdown-item" href="./AssetLoader">Save Asset</a>
        <!-- <a class="dropdown-item" href="./SearchAssetLoader?searchType=advance">Advanced Search</a> -->
      </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#"  data-toggle="dropdown">
        User
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="./searchUser.jsp">Search User</a>
        <a class="dropdown-item" href="./createUser.jsp">Create User</a>
      </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#"  data-toggle="dropdown">
        Download
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="./DownloadTemplate">Download asset upload template</a>
      </div>
    </li>
  </ul>
  <ul class="navbar-nav ml-auto">
  		<%
  			com.assetware.beans.AWUser user = (com.assetware.beans.AWUser) session.getAttribute("user");
  			if (user!= null) {
  			
  		%>
	  	<li class="nav-item dropdown">
	  		<a class="nav-link dropdown-toggle" href="#"  data-toggle="dropdown">
	        	<%=user.getEmail() %>
	      	</a>
	      <div class="dropdown-menu dropdown-menu-right">
	        <a class="dropdown-item" href="./changePass.jsp">Change password</a>
	        <a class="dropdown-item" href="./Logout">Logout</a>
	      </div>
	  	</li>
		<%
  			}
		%>
  </ul>
  </div>
</nav>