<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu">
    <main class="row justify-content-center">
        <div class="col-6">
            <h4>Liste des trucs a la con</h4>
            <table class="table table-striped table-hover table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>Description</th>
                        <th>Categorie</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.nom}</td>
                            <td>${todo.categorie}</td>
                            <td class="text-center">
                                <a href="supTodo?todo=${todo.nom}&categorie=${todo.categorie}">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
<%--Button--%>
            <a href="add-todo" class="btn btn-info btn-block">
                <i class="fa fa-plus"></i> Nouvelle note
            </a>
<%--Button--%>
        </div>
    </main>
</div>

<%@include file="../templates/footer.jsp"%>
