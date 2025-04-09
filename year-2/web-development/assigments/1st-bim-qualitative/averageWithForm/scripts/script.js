document.getElementById('grades').addEventListener('submit', function (event) {
    event.preventDefault();

    const grade1 = parseFloat(document.getElementById('grade1').value);
    const grade2 = parseFloat(document.getElementById('grade2').value);
    const grade3 = parseFloat(document.getElementById('grade3').value);
    const resultDiv = document.getElementById('result');

    if (isNaN(grade1) || isNaN(grade2) || isNaN(grade3)) {
        resultDiv.textContent = 'Por favor, preencha todas as notas com valores válidos.';
        return;
    }

    const average = (grade1 + grade2 + grade3) / 3;
    const rounded = average.toFixed(2);

    resultDiv.textContent = `A média das notas é: ${rounded}`;
});