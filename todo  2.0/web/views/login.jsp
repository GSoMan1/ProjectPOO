<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu">
    <div class="row justify-content-center">
        <div class="col-4">
            <h3 class="p-3 bg-primary text-white text-center">Login Todo App</h3>
            <form action="login" method="post">
                <p class="bg-danger text-white">${errorMessage}</p>
                <div class="form-group">
                    <input type="text" class="form-control" name="nom"
                           placeholder="Nom">
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" name="pass"
                           placeholder="Password">
                </div>

                    <input type="submit" class="btn btn-primary btn-block"
                           value="login">

            </form>
        </div>
    </div>
</div>


<%@include file="../templates/footer.jsp"%>