<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu">
    <main class="row justify-content-center">
        <div class="col-6">
            <h4>Liste des trucs a faire</h4>
            <table class="table table-striped table-hover table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>Description</th>
                        <th>Categories</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.nom}</td>
                            <td>${todo.categorie}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-info btn-block">
                <i class="fa fa-plus"></i>Nouvelle note
            </a>
        </div>
    </main>

</div>


<%@include file="../templates/footer.jsp"%>