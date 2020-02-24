window.onload = function () {
    $('.menu')
        .animate({ right: 0 }, 5000)
        .slideToggle(500)
        .queue(function () {
            $(this).css({
                background: 'rgba(0, 0, 0, 0.5)',
                border: '0.1vw dashed yellow'
            })
            $(this).dequeue()
            $('a.word').html('&#9776;')
            $('.menu').slideToggle(500)
        })

    $(function () {
        $('.menu').click(function () {
            $('.dropdown').slideToggle(500)
        })
    })

    $(function () {
        let pressed = 0
        $('.contents').click(function () {
            if (pressed == 0) {
                $(this).css({
                    color: 'white',
                    transition: 'transform 1s',
                    transform: 'scale(1)'
                })
                pressed = 1
            } else {
                $(this).css({
                    color: 'lightgreen',
                    transition: 'transform 1s',
                    transform: 'scale(0.97)'
                })
                pressed = 0
            }
        })
    })

    document.getElementById("music").play()

}