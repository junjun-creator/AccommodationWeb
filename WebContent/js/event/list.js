window.addEventListener('load', function() {
    var eventEnd = document.querySelector('.event-end');
    var eventEndContainer = eventEnd.parentElement.parentElement;

    eventEndContainer.onclick = function(e) {
        e.preventDefault();
    }
}); 