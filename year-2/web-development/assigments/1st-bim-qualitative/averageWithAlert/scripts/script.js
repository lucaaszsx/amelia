window.onload = function() {
    const grades = Array.from({ length: 3 }, (_, i) => parseFloat(window.prompt(`Digite a ${i + 1}° nota do aluno: `)));
    const average = grades.reduce((acc, c) => acc + c, 0) / 3;
    
    window.alert(`A média final do aluno com as notas (${grades.map((grade) => grade.toFixed(2)).join(', ')}) foi: ${average.toFixed(2)}. A situação desse aluno é: ${average >= 6 ? 'aprovado' : average >= 3 ? 'precisa de intervenção' : 'reprovado'}.`);
};