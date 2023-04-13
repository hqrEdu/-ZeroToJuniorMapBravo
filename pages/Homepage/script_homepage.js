const container = document.querySelector(".first-container");

container.addEventListener("mouseover", function() {
    container.style.transform = "scale(1)";
    container.style.transitionDuration="0.8s";
    container.style.transitionTimingFunction="linear";

});

container.addEventListener("mouseout", function() {
    container.style.transform = "scale(1)";
});
