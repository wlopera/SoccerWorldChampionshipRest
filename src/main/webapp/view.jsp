<!DOCTYPE html>
<html ng-app="WSChampionshipApp">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular-resource.min.js"></script>
    <script src="js/app.js"></script>
    <script src="js/service.js"></script>
    <title>WSChampionship</title>
</head>
<body ng-controller="WSChampionshipController">
    <div class="wrapper">
        <!-- Header -->
        <div class="header header-fixed navbar container-fluid">
            <div class="row">
                <div class="brand col-sm-12">
                    <a href="#" class="navbar-brand">
                        <i class="glyphicon glyphicon-heart-empty"></i>
                        <span class="heading-font">WSChampionship app</span>
                    </a>
                </div>
            </div>
        </div>

        <div class="box">
            <div class="row">
                
                <div class="col-sm-3" id="sidebar">
                    <p class="nav-title"> 
                        Campeonatos Mundiales
                        <a href="#" class="pull-right">
                            <i class="glyphicon glyphicon-folder-open"></i>
                        </a>
                    </p>
                    <ul class="nav">
                        <li ng-repeat="dato in data.data" ng-class="{active: isCurrentCategory(dato)}">
                            <a href="#" ng-click="setCurrentCategory(dato)">
                                <i class="glyphicon glyphicon-tags"></i>
                                {{dato.country}} {{dato.year}}</a>
                        </li>
                    </ul>                  
                </div>

                <div class="col-sm-9" id="main">
                    <div class="padding">
                        <div class="full col-sm-9">
                            <!-- content -->
                            <h2>
                                Category: {{currentCategory.name}}
                                <a href="#" class="btn btn-primary btn-xs pull-right" ng-click="showWindow()">
                                    <i class="glyphicon glyphicon-plus-sign"></i>
                                New bookmarks</a>
                            </h2>
                            <ul >
                                <li ng-repeat="bookmark in bookmarks | filter:{category:{name: currentCategory.name}}">
                                    
                                    <p>
                                        <a href="{{bookmark.url}}"> {{bookmark.title}}</a><br/>
                                        <i class="glyphicon glyphicon-trash" ng-click="remove(bookmark)"></i>
                                        <i class="glyphicon glyphicon-pencil" ng-click="showWindow(bookmark)"></i><br/>
                                        <small>{{bookmark.url}}</small>
                                    </p>
                                </li>
                            </ul>
                        </div>                                    
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="modal fade" id="bookmarkModal" tabindex="1" role="dialog" 
        aria-labelledby="myModalLabel" aria-hidden="false">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>
              <h4 class="modal-title" id="myModalLabel">Bookmark</h4>
            </div>
            <div class="modal-body">
                <form name="bookmarkForm" id="bookmarkForm">
                    <p>Por favor, introduzca la url de su bookmark, todos los campos son requeridos</p>
                    <div class="form-group">
                        <label for="category">Categoria</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="glyphicon glyphicon-folder-open"></i>
                            </div>
                            <select ng-model="bookmark.category" ng-options="obj.name for obj in categories track by obj.id" 
                            id="category" class="form-control"></select>
                        </div>
                    </div>
                    <div class="form-group" ng-class="{'has-error':bookmarkForm.title.$invalid &&
                    bookmarkForm.title.$dirty}">
                        <label for="title">Title</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="glyphicon glyphicon-bookmark"></i>
                            </div>
                            <input ng-model="bookmark.title" required name="title" id="title" class="form-control" type="text"
                            placeholder="Introduzca el Titulo">
                            <span ng-if="bookmarkForm.title.$invalid && bookmarkForm.title.$dirty" 
                            class="glyphicon glyphicon-remove form-control-feedback"></span>
                        </div>
                        <span ng-if="bookmarkForm.title.$invalid && bookmarkForm.title.$dirty" 
                        class="help-block">Título Requerido</span>
                    </div>
                    <div class="form-group" ng-class="{'has-error':bookmarkForm.url.$invalid &&
                    bookmarkForm.url.$touched}">
                        <label for="url">URL</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="glyphicon glyphicon-link"></i>
                            </div>
                            <input ng-model="bookmark.url" ng-required="true" name="url" id="url" 
                            minlength="3" maxlength="150"
                            class="form-control" type="url" placeholder="Introduzca la URL">
                            <span ng-if="bookmarkForm.url.$invalid && bookmarkForm.url.$dirty" 
                            class="glyphicon glyphicon-remove form-control-feedback"></span>
                        </div>
                        <span ng-if="bookmarkForm.url.$error.requerid && bookmarkForm.url.$touched" 
                        class="help-block">URL Requerida</span>
                        <span ng-if="bookmarkForm.url.$error.minlength && bookmarkForm.url.$touched" 
                        class="help-block">URL muy pequeña</span>
                        <span ng-if="bookmarkForm.url.$error.maxlength && bookmarkForm.url.$touched" 
                        class="help-block">URL muy grande</span>
                        <span ng-if="bookmarkForm.url.$error.url && bookmarkForm.url.$touched" 
                        class="help-block">URL con formato incorrecto, ej: <strong>http://test.com</strong> </span>                        
                    </div>
                </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              <button ng-click="save(bookmark)" type="button" class="btn btn-primary">Save changes</button>
            </div>
          </div>
        </div>
      </div>
</body>
</html>