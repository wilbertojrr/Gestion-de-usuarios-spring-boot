$(document).ready(function() {
        $("#logout").click(function(){
            localStorage.login="false";
            localStorage.removeItem("token");
            localStorage.removeItem("email");
            window.location.href = "login.html";
        });
});