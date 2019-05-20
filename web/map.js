window.onload = function() {
  let myMap;
  let coordsButton = document.getElementById('get-coordinates-button');
  coordsButton.onclick = function () {
      console.log('a')
  }
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
  }
};
