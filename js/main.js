function login() {
  const result = confirm('로그인 후 사용가능합니다.\n로그인 하시겠습니까?');
  if (result) {
      location.href='/login';
  }
}

function popOpen() {
  var modalPop = $('.modal-wrap');
  var modalBg = $('.modal-bg');

  $(modalPop).show();
  $(modalBg).show();

  $('html').css({
    overflow: 'hidden',
    height: 'auto';
  });
}

function popClose() {
  var modalPop = $('.modal-wrap');
  var modalBg = $('.modal-bg');

  $(modalPop).hide();
  $(modalBg).hide();

  $('html').removeAttr('style');
}
