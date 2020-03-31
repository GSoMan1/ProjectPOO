<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu"><!-- container -->
    <main class="row justify-content-center">
        <div class="col-6"><!-- col-6 -->
            <h4 class="text-light bg-dark">Categories </h4><!-- titre -->
            <table class="table table-striped table-hover table-bordered"><!-- affichage -->
                <thead>
                <tr>
                    <td><h5>ID</h5></td>
                    <td><h5>Nom</h5></td>
                    <td><h5>Options</h5></td>
                </tr>
                </thead>
                <tbody><!-- table body -->
                <c:forEach items="${categories}" var="categories">
                    <tr>
                        <td>${categories.getId()}</td>
                        <td>${categories.getName()}</td>
                        <td class="text-center">
                            <div class="btn-group" role="group">
                                    <!-- boutons actions -->
                                    <a href="./editcategory?catid=${categories.getId()}" class="btn btn-outline-secondary btn-sm">
                                        <i class="fas fa-edit"></i>
                                    </a>
                                    <a href="./delcategory?id=${categories.getId()}" class="btn btn-outline-secondary btn-sm">
                                        <i class="fas fa-trash"></i>
                                    </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody><!-- fin body -->
            </table><!-- fin affichage -->
            <!-- bouton ajout -->
            <a href="./editcategory?catid=0" class="btn btn-outline-success btn-lg btn-block">
                <i class="fas fa-plus"></i>Ajouter une categorie
            </a>
        </div><!-- fin col-6 -->
    </main>
</div>
<!-- fin container -->


<%@include file="../templates/footer.jsp"%>
