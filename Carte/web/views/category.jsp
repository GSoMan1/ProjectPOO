<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu"><!-- container -->
    <main class="row justify-content-center">
        <div class="col-6"><!-- col-6 -->
            <h4 class="text-light bg-dark">${category.getName()}</h4><!-- titre -->
            <table class="table table-striped table-hover table-bordered"><!-- affichage -->
                <tbody><!-- table body -->
                <c:forEach items="${dishes}" var="dishes">
                    <tr>
                        <td>${dishes.getId()}</td>
                        <td>${dishes.getTitle()}</td>
                        <td>${dishes.getDescription()}</td>
                        <td>${dishes.getPrice()}</td>
                        <td class="text-center">
                            <div class="btn-group" role="group">
                                    <!-- boutons actions -->
                                    <a href="./editdish?dishid=${dishes.getId()}" class="btn btn-outline-secondary btn-sm">
                                        <i class="fas fa-edit"></i>
                                    </a>
                                    <a href="deldish?id=${dishes.getId()}" class="btn btn-outline-secondary btn-sm">
                                        <i class="fas fa-trash"></i>
                                    </a>
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