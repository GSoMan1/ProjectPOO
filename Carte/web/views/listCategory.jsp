<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu"><!-- container -->
    <main class="row justify-content-center">
        <div class="col-6"><!-- col-6 -->
            <h4 class="text-light bg-dark">Categories</h4><!-- titre -->
            <table class="table table-striped table-hover table-bordered"><!-- affichage -->
                <tbody><!-- table body -->
                <c:forEach items="${categories}" var="categories">
                    <tr>
                        <td>${categories.getId()}</td>
                        <td>${categories.getName()}</td>
                        <td class="text-center">
                            <div class="btn-group" role="group">
                                <form action="update-club" method="post">
                                    <input type="hidden" value="list" name="from">
                                    <input type="hidden" value="${categories.getId()}" name="id">
                                    <!-- boutons actions -->
                                    <button type="submit" class="btn btn-warning btn-sm">
                                        <i class="fas fa-pen"></i>
                                    </button>
                                    <a href="./delcategory?id=${categories.getId()}" class="btn btn-danger btn-sm">
                                        <i class="fas fa-trash-alt"></i>
                                    </a>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody><!-- fin body -->
            </table><!-- fin affichage -->
        </div><!-- fin col-6 -->
    </main>
</div>
<!-- fin container -->


<%@include file="../templates/footer.jsp"%>
