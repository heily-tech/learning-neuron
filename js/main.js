fetch("footer.html").then(response => {
    return response.text()
}).then(data => {
    document.querySelector("footer").innerHTML = data;
});

fetch("main_header.html").then(response => {
  return response.text()
}).then(data => {
  document.querySelector("header").innerHTML = data;
});
