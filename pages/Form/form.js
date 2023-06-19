const form = document.querySelector("form");
const submitBtn = document.getElementById("submit");
const nick = document.getElementById("nick");
const country = document.getElementById("country");
const city = document.getElementById("city");
const zip_code = document.getElementById("zip_code");
const privacy_law = document.getElementById("privacy_law");

function nickError() {
  if (nick.value === undefined || nick.value === "") {
    nick.setAttribute("placeholder", "Pole nie może być puste. Wypełnij je.");
    nick.style.border = "1px solid red";
  }
}
function countryError() {
  if (country.value === undefined || country.value === "") {
    country.setAttribute(
      "placeholder",
      "Pole nie może być puste. Wypełnij je."
    );
    country.style.border = "1px solid red";
  }
}
function cityError() {
  if (city.value === undefined || city.value === "") {
    city.setAttribute("placeholder", "Pole nie może być puste. Wypełnij je.");
    city.style.border = "1px solid red";
  }
}
function zipError() {
  if (zip_code.value === undefined || zip_code.value === "") {
    zip_code.setAttribute(
      "placeholder",
      "Pole nie może być puste. Wypełnij je."
    );
    zip_code.style.border = "1px solid red";
  }
}

function privacyError() {
    if (!privacy_law.checked) {
    privacy_law.setAttribute(
      "checked",
      "Pole nie może być puste. Wypełnij je."
    );
    privacy_law.style.border = "1px solid red";
  }
}

function sendForm() {
  if (
    nick?.value.trim() &&
    country?.value.trim() &&
    city?.value.trim() &&
    zip_code?.value.trim() &&
    privacy_law?.checked
  ) {
    submitBtn.disabled = false;
  } else {
    submitBtn.disabled = true;
  }
}

form?.addEventListener("input", nickError);
form?.addEventListener("input", countryError);
form?.addEventListener("input", cityError);
form?.addEventListener("input", zipError);
form?.addEventListener("change", privacyError);
form?.addEventListener("change", sendForm);

// Receiving  data from user form
submitBtn.addEventListener("click", function(event){
  event.preventDefault();
  const formData = new FormData(form);
  const data = {
      nickname: formData.get("nick"),
      city: formData.get("city"),
      zipCode: formData.get("zip_code"),
      country: formData.get("country"),
  };
  sendData(data);
})
// Send data to database
function sendData(data) {
    console.log("Wysyłam zapytanie...", data);
    fetch('https://z2j-bravo.hqr.at/api/users', {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(function (response) {
            console.log("Odpowiedź od serwera:", response);
            if (!response.ok) {
                throw new Error("Błąd podczas wysyłania danych użytkownika");
            }
            return response.json();
        })
        .then(function (user) {
            console.log("Dodano użytkownika", user);
        })
        .catch(function (error) {
            console.error("Błąd podczas przesyłania danych użytkownika", error);
        })
        .catch(function (networkError) {
            console.error("Błąd sieciowy", networkError);
        });
}