const colorCodes = {
  black: { value: 0, multiplier: 1, color: "Preto" },
  brown: { value: 1, multiplier: 10, tolerance: "±1%", color: "Marrom" },
  red: { value: 2, multiplier: 100, tolerance: "±2%", color: "Vermelho" },
  orange: { value: 3, multiplier: 1000, color: "Laranja" },
  yellow: { value: 4, multiplier: 10000, color: "Amarelo" },
  green: { value: 5, multiplier: 100000, tolerance: "±0.5%", color: "Verde" },
  blue: { value: 6, multiplier: 1000000, tolerance: "±0.25%", color: "Azul" },
  violet: { value: 7, multiplier: 10000000, tolerance: "±0.1%", color: "Violeta" },
  gray: { value: 8, tolerance: "±0.05%", color: "Cinza" },
  white: { value: 9, color: "Branco" },
  gold: { multiplier: 0.1, tolerance: "±5%", color: "Ouro" },
  silver: { multiplier: 0.01, tolerance: "±10%", color: "Prata" }
};

const band1 = document.getElementById("band1");
const band2 = document.getElementById("band2");
const multiplier = document.getElementById("multiplier");
const tolerance = document.getElementById("tolerance");
const result = document.getElementById("result");

function populateSelect(select, filter) {
  for (const color in colorCodes) {
    if (colorCodes[color][filter] !== undefined) {
      const option = document.createElement("option");
      option.value = color;
      option.textContent = colorCodes[color].color;
      select.appendChild(option);
    }
  }
}

populateSelect(band1, "value");
populateSelect(band2, "value");
populateSelect(multiplier, "multiplier");
populateSelect(tolerance, "tolerance");

document.getElementById("resistorForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const digit1 = colorCodes[band1.value].value;
  const digit2 = colorCodes[band2.value].value;
  const multiplierValue = colorCodes[multiplier.value].multiplier;
  const toleranceValue = colorCodes[tolerance.value].tolerance;

  const resistance = ((digit1 * 10) + digit2) * multiplierValue;

  result.innerHTML = `
    <strong>Resistência:</strong> ${resistance >= 1000 ? (resistance / 1000) + " kΩ" : resistance + " Ω"}<br>
    <strong>Tolerância:</strong> ${toleranceValue}
  `;
});