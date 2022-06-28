const modal = document.querySelector('.modal');
const close = document.querySelector('.modal_close');
const enterBtn = document.querySelector('.modal_open_enter');
const createBtn = document.querySelector('.modal_open_create');
const enter = document.querySelector('.modal_enter');
const create = document.querySelector('.modal_create');

enterBtn.onclick = function() {
  modal.style.display = 'block';
  create.style.display = 'none';
  enter.style.display = 'block';
}
createBtn.onclick = function() {
  modal.style.display = 'block';
  enter.style.display = 'none';
  create.style.display = 'block';
}

close.onclick = function() {
        modal.style.display = "none";
}
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
