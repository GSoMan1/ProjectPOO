<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container contenu"><!-- container -->
    <main class="row justify-content-center">
        <div class="col-6"><!-- col-6 -->
            <h4 class="text-light bg-dark">${category.getName()}</h4><!-- titre -->
            <table class="table table-striped table-hover table-bordered"><!-- affichage -->
                <thead>
                <tr>
                    <td><h5>ID</h5></td>
                    <td><h5>Titre</h5></td>
                    <td><h5>Description</h5></td>
                    <td><h5>Prix</h5></td>
                    <td><h5>Options</h5></td>
                </tr>
                </thead>
                <tbody><!-- table body -->
                <c:forEach items="${dishes}" var="dishes">
                    <tr>
                        <td>${dishes.getId()}</td>
                        <td>${dishes.getTitle()}</td>
                        <td>${dishes.getDescription()}</td>
                        <td><fmt:formatNumber value="${dishes.getPrice()}" type="currency" currencySymbol="&euro;" /></td>
                        <td class="text-center">
                            <div class="btn-group" role="group">
                                    <!-- boutons actions -->
                                    <a href="./editdish?dishid=${dishes.getId()}&catid=${dishes.getCategory().getId()}" class="btn btn-outline-secondary btn-sm">
                                        <i class="fas fa-edit"></i>
                                    </a>
                                    <a href="deldish?id=${dishes.getId()}" onclick="return confirm('Êtes-vous sûr vouloir supprimer ce plat?')"  class="btn btn-outline-secondary btn-sm">
                                        <i class="fas fa-trash"></i>
                                    </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody><!-- fin body -->
            </table><!-- fin affichage -->
            <!-- bouton ajout -->
            <a href="./editdish?dishid=0&catid=${category.getId()}" class="btn btn-outline-success btn-lg btn-block">
                <i class="fas fa-plus"></i>Ajouter un plat
            </a>
        </div><!-- fin col-6 -->
    </main>
</div>
<!-- fin container -->


<%@include file="../templates/footer.jsp"%>