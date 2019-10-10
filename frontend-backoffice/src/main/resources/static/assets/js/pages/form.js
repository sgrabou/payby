var form = document.getElementById("myForm");

// Get the button that opens the form
var addNew = document.getElementById("addNewBtn");

// Get the <span> element that closes the form
var span = document.getElementsByClassName("close")[0];

var userSubmitBtn = document.getElementById("userSubmitBtn");

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


userSubmitBtn.onclick = function() {
  console.log("hhhh");
  $.ajax('http://localhost:8060/admin/api/v1/user', {
    type: 'post',
    dataType: 'json',
    contentType: 'application/json',
    data: {
      name: $("#userName").val(),
      password: $("#userPassword").val(),
      roles:$("#roles").val(),
    },
  }).done(function(r) {
    var result = JSON.parse(r);
    if (typeof result === 'undefined') return;
    // export status 1 is completed

    /*	if (result.export_status !== 1) return;
        $('<iframe/>').attr({
            src: 'index.php?builder_export&builder_download&id=' + result.id,
            style: 'visibility:hidden;display:none',
        }).ready(function() {
            toastr.success('Export Default Version', 'Default HTML version exported with current configured layout.');
            exporter.doneLoad();
            // stop the timer
            clearInterval(timer);
        }).appendTo('body');
    */
  });
}