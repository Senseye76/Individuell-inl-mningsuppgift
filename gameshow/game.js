// ===== Spelets tillstånd (state) =====
let teams = [];          // t.ex. [{ name: "Lag 1", score: 0 }]
let current = null;      // frågan som visas just nu
let answeredCount = 0;
let timerId = null;

const TOTAL_QUESTIONS = CATEGORIES.reduce((sum, c) => sum + c.questions.length, 0);

// Kortare sätt att hämta element
const $ = (id) => document.getElementById(id);

// ===== Startskärm =====
function addTeamInput(name = "") {
  const input = document.createElement("input");
  input.placeholder = `Lag ${$("team-inputs").children.length + 1}`;
  input.value = name;
  $("team-inputs").appendChild(input);
}

function startGame() {
  const inputs = [...$("team-inputs").querySelectorAll("input")];
  teams = inputs.map((input, i) => ({
    name: input.value.trim() || `Lag ${i + 1}`,
    score: 0,
  }));
  answeredCount = 0;
  buildBoard();
  renderScores();
  showScreen("game");
}

function showScreen(id) {
  ["setup", "game", "end"].forEach((s) => $(s).classList.toggle("hidden", s !== id));
}

// ===== Brädet =====
function buildBoard() {
  const board = $("board");
  board.innerHTML = "";
  const rows = Math.max(...CATEGORIES.map((c) => c.questions.length));

  // Första raden: kategorinamn
  CATEGORIES.forEach((cat) => {
    const div = document.createElement("div");
    div.className = "category";
    div.textContent = cat.title;
    board.appendChild(div);
  });

  // Sedan en rad per poängnivå
  for (let r = 0; r < rows; r++) {
    CATEGORIES.forEach((cat) => {
      const q = cat.questions[r];
      const cell = document.createElement("div");
      cell.className = "cell";
      if (q) {
        cell.textContent = q.points;
        cell.addEventListener("click", () => openQuestion(cat, q, cell));
      } else {
        cell.classList.add("used");
      }
      board.appendChild(cell);
    });
  }
}

function renderScores() {
  $("scores").innerHTML = teams
    .map((t) => `<div class="score">${t.name}<strong>${t.score}</strong></div>`)
    .join("");
}

// ===== Frågerutan =====
function openQuestion(category, q, cell) {
  if (cell.classList.contains("used")) return;
  current = { q, cell };

  $("modal-category").textContent = `${category.title} – ${q.points} poäng`;
  $("modal-question").textContent = q.question;
  $("modal-answer").textContent = q.answer;
  $("modal-answer").classList.add("hidden");
  $("award").classList.add("hidden");
  $("show-answer").classList.remove("hidden");
  $("modal").classList.remove("hidden");

  // Knappar för poäng: rätt (+) eller fel (−) per lag
  $("award-buttons").innerHTML = "";
  teams.forEach((team) => {
    const right = document.createElement("button");
    right.textContent = `${team.name} +${q.points}`;
    right.onclick = () => award(team, q.points);

    const wrong = document.createElement("button");
    wrong.className = "wrong";
    wrong.textContent = `${team.name} −${q.points}`;
    wrong.onclick = () => { team.score -= q.points; renderScores(); wrong.disabled = true; };

    $("award-buttons").append(right, wrong, document.createElement("br"));
  });
  const nobody = document.createElement("button");
  nobody.className = "nobody";
  nobody.textContent = "Ingen svarade rätt";
  nobody.onclick = () => closeQuestion();
  $("award-buttons").appendChild(nobody);

  startTimer(30);
}

function startTimer(seconds) {
  clearInterval(timerId);
  let left = seconds;
  const el = $("timer");
  el.textContent = left;
  el.classList.remove("low");

  timerId = setInterval(() => {
    left--;
    el.textContent = left;
    if (left <= 5) el.classList.add("low");
    if (left <= 0) {
      clearInterval(timerId);
      el.textContent = "Tiden är ute!";
    }
  }, 1000);
}

function showAnswer() {
  clearInterval(timerId);
  $("modal-answer").classList.remove("hidden");
  $("award").classList.remove("hidden");
  $("show-answer").classList.add("hidden");
}

function award(team, points) {
  team.score += points;
  closeQuestion();
}

function closeQuestion() {
  clearInterval(timerId);
  current.cell.classList.add("used");
  $("modal").classList.add("hidden");
  renderScores();
  answeredCount++;
  if (answeredCount === TOTAL_QUESTIONS) endGame();
}

// ===== Slut =====
function endGame() {
  const sorted = [...teams].sort((a, b) => b.score - a.score);
  const best = sorted[0].score;
  const winners = sorted.filter((t) => t.score === best).map((t) => t.name);

  $("winner").textContent =
    winners.length > 1 ? `Oavgjort: ${winners.join(" & ")}! 🏆` : `${winners[0]} vinner! 🏆`;
  $("final-scores").innerHTML = sorted
    .map((t) => `<div class="score">${t.name}<strong>${t.score}</strong></div>`)
    .join("");
  showScreen("end");
}

// ===== Koppla knappar =====
$("add-team").onclick = () => addTeamInput();
$("start").onclick = startGame;
$("show-answer").onclick = showAnswer;
$("restart").onclick = () => showScreen("setup");

// Börja med två lag
addTeamInput();
addTeamInput();
