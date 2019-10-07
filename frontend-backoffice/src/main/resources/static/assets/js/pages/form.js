var form = document.getElementById("myForm");

// Get the button that opens the form
var addNew = document.getElementById("addNewBtn");

// Get the <span> element that closes the form
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the form
addNew.onclick = function() {
  form.style.display = "block";
}

// When the user clicks on <span> (x), close the form
span.onclick = function() {
  form.style.display = "none";
}

// When the user clicks anywhere outside of the form, close it
window.onclick = function(event) {
  if (event.target == form) {
    form.style.display = "none";
  }
};