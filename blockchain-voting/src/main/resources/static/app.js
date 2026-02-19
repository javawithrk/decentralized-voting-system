async function castVote() {

    const voterId = document.getElementById("voterId").value;
    const candidate = document.getElementById("candidate").value;

    const response = await fetch("/api/vote", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ voterId, candidate })
    });

    const message = await response.text();

    document.getElementById("message").innerHTML =
        `<div class="alert alert-info">${message}</div>`;
}

async function loadBlockchain() {

    const response = await fetch("/api/vote/chain");
    const data = await response.json();

    const table = document.getElementById("chainTable");
    table.innerHTML = "";

    data.forEach(block => {
        const row = `
            <tr>
                <td>${block.voterId}</td>
                <td>${block.candidate}</td>
                <td>${block.previousHash}</td>
                <td>${block.hash}</td>
            </tr>`;
        table.innerHTML += row;
    });
}

let chartInstance = null;

async function loadChart() {

    // Get blockchain data
    const response = await fetch("/api/vote/chain");
    const data = await response.json();

    // Count votes per candidate
    const voteCount = {};

    data.forEach(block => {

        // Skip Genesis block
        if (block.candidate === "Genesis") return;

        if (voteCount[block.candidate]) {
            voteCount[block.candidate]++;
        } else {
            voteCount[block.candidate] = 1;
        }
    });

    const labels = Object.keys(voteCount);
    const values = Object.values(voteCount);

    const ctx = document.getElementById("voteChart").getContext("2d");

    // Destroy old chart before creating new one
    if (chartInstance) {
        chartInstance.destroy();
    }

    chartInstance = new Chart(ctx, {
        type: "bar",
        data: {
            labels: labels,
            datasets: [{
                label: "Total Votes",
                data: values
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    display: true
                }
            },
            scales: {
                y: {
                    beginAtZero: true,
                    precision: 0
                }
            }
        }
    });
}

async function detectWinner() {

    const response = await fetch("/api/vote/chain");
    const data = await response.json();

    const voteCount = {};

    // Count votes from blockchain
    data.forEach(block => {

        if (block.candidate === "Genesis") return;

        if (voteCount[block.candidate]) {
            voteCount[block.candidate]++;
        } else {
            voteCount[block.candidate] = 1;
        }
    });

    let maxVotes = 0;
    let winner = "";
    let tie = false;

    for (const candidate in voteCount) {

        if (voteCount[candidate] > maxVotes) {
            maxVotes = voteCount[candidate];
            winner = candidate;
            tie = false;
        }
        else if (voteCount[candidate] === maxVotes) {
            tie = true;
        }
    }

    const resultDiv = document.getElementById("winnerResult");

    if (Object.keys(voteCount).length === 0) {
        resultDiv.innerHTML = `<span class="text-danger">No votes cast yet.</span>`;
        return;
    }

    if (tie) {
        resultDiv.innerHTML =
            `<span class="text-warning">⚖ It's a Tie!</span>`;
    } else {
        resultDiv.innerHTML =
            `<span class="text-success">Winner: ${winner} (${maxVotes} votes)</span>`;
    }
}

async function validateChain() {

    const response = await fetch("/api/vote/validate");
    const result = await response.text();

    const div = document.getElementById("validationResult");

    if (result.includes("VALID")) {
        div.innerHTML = `<span class="text-success">✅ ${result}</span>`;
    } else {
        div.innerHTML = `<span class="text-danger">❌ ${result}</span>`;
    }
}
