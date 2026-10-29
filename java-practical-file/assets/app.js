(function(){
var P=window.PROFILE||{};
document.querySelectorAll('[data-profile]').forEach(function(el){var v=P[el.getAttribute('data-profile')];if(v){el.textContent=v}else{var r=el.closest('[data-row]');if(r)r.hidden=true}});
})();
