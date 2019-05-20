<%--
  Created by IntelliJ IDEA.
  User: yan
  Date: 5/20/19
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Создание и удаление</title>
  <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU&amp;apikey=6509ccff-07ff-4376-b2bd-d751b931b430"
          type="text/javascript"></script>
  <script src="map.js" type="text/javascript"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
    body,
    html {
      padding: 0;
      margin: 0;
      width: 100%;
      height: 100%;
    }

    #map {
      width: 100%;
      height: 90%;
    }
  </style>
</head>

<body>
<nav class="navbar bg-primary">
  <a class="navbar-brand" style="color:white; height:10%;" href="#">Roads map</a>
  <form class="form-inline">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#requestModal">
      Create report
    </button>
  </form>
</nav>
</div>
<div class="modal" id="requestModal">
  <div class="modal-dialog" style="margin-top:10vh;">
    <div class="modal-content">
      <form>

        <div class="modal-header">
          <h4 class="modal-title">Pit report</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>

        <div class="modal-body" id="pit-request-modal-body">
          <div class="container d-flex justify-content-center">
            <div class="row ">
              <div class="col-12">
                <div class="form-group">
                  <label for="latitude">Latitude</label>
                  <input id="latitude" class="form-control" type="text" placeholder="Latitude: " readonly>
                </div>
                <div class="form-group">
                  <label for="longitude">Longtitude</label>
                  <input id="longitude" class="form-control" type="text" placeholder="Longitude: " readonly>
                </div>
                <button type="button" class="btn btn-primary" id="get-coordinates-button">Get coordinates</button>
                <div class="form-group mt-5">
                  <label for="Description">Description</label>
                  <textarea class="form-control" id="Description" rows="5"></textarea>
                </div>
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
                  </div>
                  <div class="custom-file">
                    <input type="file" accept="image/*" class="custom-file-input" id="inputFile"
                           aria-describedby="inputGroupFileAddon01">
                    <label class="custom-file-label" id="label" for="inputFile"></label>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="modal-footer d-flex justify-content-between" style="padding-left: 13%; padding-right: 13%;">
          <button id="reaction" type="submit" class="btn btn-success p-2 mr-auto">Send reaction</button>
          <button type="button" class="btn btn-danger p-2" data-dismiss="modal">Close</button>
        </div>
      </form>
    </div>
  </div>
</div>
<div id="map"></div>
</body>

</html>
