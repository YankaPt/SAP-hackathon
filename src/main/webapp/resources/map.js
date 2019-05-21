function handleClick(coords) {
    document.getElementById('latitude').value = coords[0];
    document.getElementById('longitude').value = coords[1];
}

window.onload = function() {
  let myMap;
  let coordsButton = new ymaps.control.Button("Create pit report");
  let eraseButton = new ymaps.control.Button("Erase");
  let loginButton = new ymaps.control.Button("Login");

  let collection = new ymaps.GeoObjectCollection(null, { preset: "islands#orangeIcon"});
  ymaps.ready(init);

  function init() {
    myMap = new ymaps.Map(
      "map",
      {
        center: [53.9, 27.56667],
        zoom: 12
      },
      {
        searchControlProvider: "yandex#search"
      }
    );
    eraseButton.events.add('click', function(){
        collection.removeAll();
    })
    loginButton.events.add('click', function(){
        $('#loginModal').modal();
    })
    
    
    myMap.events.add('click', function (e) {
        
        var coords = e.get('coords');
        let markerToAdd = new ymaps.Placemark(coords, {
            hintContent  : `<button type="button" class="btn btn-primary" id="get-coordinates-button" data-toggle="modal" data-target="#requestModal" onclick="${handleClick(coords)}">Create report</button>`
        }, {
            //preset: 'islands#icon',
            //iconColor: '#0095b6'
        })
        const length = collection.getLength();
        if(markerToAdd && length > 0){
            collection.remove(length - 1)
        }
        collection.add(markerToAdd)
    });
    //myMap.controls.add(coordsButton, {float: 'right'});
    myMap.controls.add(eraseButton, {float:'right'});
    myMap.controls.add(loginButton, {float:'right'});
    myMap.geoObjects.add(collection);

  }
};
