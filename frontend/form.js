const form = document.getElementById("form");
const submitBtn = document.getElementById("submit");
const fname = document.getElementById("fname");
const nick = document.getElementById("nick");
const country = document.getElementById("country");
const city = document.getElementById("city");
const zip_code = document.getElementById("zip_code");
const privacy_law = document.getElementById("privacy_law");

function sendForm() {
  let fnameFieldValue = fname?.value.trim();
  let nickFieldValue = nick?.value.trim();
  let countryFieldValue = country?.value.trim();
  let cityFieldValue = city?.value.trim();
  let zipFieldValue = zip_code?.value.trim();
  let privacy_lawFieldValue = privacy_law?.checked;
  if (
    fnameFieldValue &&
    nickFieldValue &&
    countryFieldValue &&
    cityFieldValue &&
    zipFieldValue &&
    privacy_lawFieldValue
  ) {
    submitBtn.removeAttribute("disabled");
  } else {
    submitBtn.setAttribute("disabled", "disabled");
  }
}

form?.addEventListener("change", sendForm);
