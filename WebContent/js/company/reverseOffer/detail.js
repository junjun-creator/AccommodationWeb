window.addEventListener('load', function () {
    var prevBtn = document.querySelector('.btn-left');
    var nextBtn = document.querySelector('.btn-right');
    var proposal = document.querySelector('.proposal-item-container');
    var proposalInfo = document.querySelectorAll('.proposal-info');

    var proposalCount = 0;

    prevBtn.addEventListener('click', function (e) {
        if (proposalCount > 0) 
            proposalCount--;
        else 
            proposalCount = proposalInfo.length - 2;

        proposal.style.transform = 'translateX(' + -350 * proposalCount + 'px)';
    });

    nextBtn.addEventListener('click', function (e) {
        if (proposalCount <= proposalInfo.length - 2 - 1) 
            proposalCount++;
        else 
            proposalCount = 0;

        proposal.style.transform = 'translateX(' + -350 * proposalCount + 'px)';
    });
});
