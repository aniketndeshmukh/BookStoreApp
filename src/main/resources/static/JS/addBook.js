
console.log("This is js")
alert("Activated")
function validateForm() {
  let x = document.forms["myForm"]["id"].value;
  let y = document.forms["myForm"]["name"].value;
  let a = document.forms["myForm"]["price"].value;
  let b = document.getElementById("id").value;



  if (x == "") {
    alert("Id must be filled out");
    return false;
  }
  if (x <= 0) {
      alert("Id must not be negative and zero");
      return false;
    }
    if (y == "") {
        alert("Book name must be filled out");
        return false;
    }
    if (a == "") {
     alert("Book price must be filled out");
     return false;
     }
     if (x <= 0) {
         alert("Book Price must not be negative and zero");
              return false;
     }
    if (b == "") {
          alert("Book Category must be filled out");
           return false;
    }

}