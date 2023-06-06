// Receiving users nickname, latitude and longitude from sql database

function getUsers(){
  fetch("https://z2j-bravo.hqr.at/api/users")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Błąd podczas pobierania danych użytkowników");
        }
        return response.json();
      })
      .then(users => {
        createUsersPosition(users);
      })
      .catch(error => {
        console.error('Błąd podczas pobierania danych użytkowników:', error);
      });
}


// Creating set of data - nickname, lattitude, longitude
function createUsersPosition(users) {
  users.forEach(user => {
    const position = new google.maps.LatLng(user.latitude, user.longitude);
    createUsersMaker(position, user);
  });
}

function createUsersMaker(position, user) {
  const marker = new google.maps.Marker({
    position: position,
    map: map,
    title: user.name
  });
}

// Initialize and add the map
let map;
async function initMap() {
  // The location of Uluru
  const position = { lat: -25.344, lng: 131.031 };
  // Request needed libraries.
  //@ts-ignore
  const { Map } = await google.maps.importLibrary("maps");
  const { AdvancedMarkerView } = await google.maps.importLibrary("marker");

  // The map, centered at Uluru
  map = new Map(document.getElementById("map"), {
    zoom: 1,
    center: position,
    mapId: "DEMO_MAP_ID",
  });
  createUsersMaker(users);

}

initMap();

// The marker, positioned at Uluru
// const marker = new AdvancedMarkerView({
//   map: map,
//   position: position,
//   title: "Uluru",
// });
