var circlesCounter = 0;

window.onload = function() {
    addCircles(9);
}

function addCircles(count) {
    var mainContainer = document.getElementById("mainContainer");
    
    for (var i=0; i<count; i++) {
        var circleDiv = document.createElement("div");
        circleDiv.innerHTML = "Circle " + (++circlesCounter) + "<br><input type=\"checkbox\" onClick=\"toggleCheckbox(this, event)\" class=\"circleCheckbox\"/>"
        circleDiv.classList.add("circleDiv");
        circleDiv.setAttribute("id", "circle-" + circlesCounter)
        circleDiv.setAttribute("onclick", "toggleCheckbox(this, event)")
        mainContainer.appendChild(circleDiv);
    }
}

function removeCircles() {
    var circleCheckboxes = document.querySelectorAll('.circleCheckbox');
    for (var i=0; i<circleCheckboxes.length; i++) {
        if (circleCheckboxes[i].checked) {
            var circleDiv = circleCheckboxes[i].parentElement;
            circleDiv.remove();
        }
    }
}

function hideCircles() {
    var circleCheckboxes = document.querySelectorAll('.circleCheckbox');
    for (var i=0; i<circleCheckboxes.length; i++) {
        if (circleCheckboxes[i].checked) {
            var circleDiv = circleCheckboxes[i].parentElement;
            circleDiv.style.display = "none";
            circleCheckboxes[i].checked = false;
        }
    }
}

function showHiddenCircles() {
    var circleDivs = document.querySelectorAll('.circleDiv');
    for (var i=0; i<circleDivs.length; i++) {
        if (circleDivs[i].style.display == "none") {
            circleDivs[i].style.display = "block";
        }
    }
}

function toggleCheckbox(element, event) {
    
    if (element.nodeName == 'DIV') {

        console.log("Clicked on DIV");

        var checkboxElement = element.getElementsByTagName('input')[0];

        if (checkboxElement.checked) {
            checkboxElement.checked = false;
        }
        else {
            checkboxElement.checked = true;
        }
    }
    else if (element.nodeName == 'INPUT') {

        console.log("Clicked on INPUT");
        event.stopPropagation();
    }
}