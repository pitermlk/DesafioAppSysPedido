document.addEventListener('DOMContentLoaded', function() {
    // Função para atualizar o temporizador
    function updateTimer() {
        // Defina a data do evento
        var eventDate = new Date('2024-12-31T00:00:00');

        // Calcule a diferença de tempo entre a data atual e a data do evento
        var now = new Date();
        var timeDiff = eventDate.getTime() - now.getTime();

        // Calcule o número de dias restantes até o evento
        var daysUntilEvent = Math.ceil(timeDiff / (1000 * 3600 * 24));

        // Atualize o valor do temporizador na página
        document.getElementById('daysUntilEvent').textContent = daysUntilEvent;
    }

    // Atualize o temporizador assim que a página for carregada
    updateTimer();

    // Atualize o temporizador a cada segundo
    setInterval(updateTimer, 1000);
});
