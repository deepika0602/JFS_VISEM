// Auto-calculate total fee
let subjects = document.querySelectorAll(".subject");
let totalBox = document.getElementById("total");

subjects.forEach(item => {
    item.addEventListener("change", () => {
        let total = 0;

        subjects.forEach(sub => {
            if (sub.checked) {
                total += parseInt(sub.value);
            }
        });

        totalBox.innerText = "₹" + total;
    });
});

// FORM SUBMIT
document.getElementById("regForm").addEventListener("submit", function(e){
    e.preventDefault();

    let selectedSubjects = [];
    let totalFee = 0;
    let count = 1;

    subjects.forEach(sub => {
        if (sub.checked) {

            // Get ONLY the subject name without price
            let fullText = sub.parentElement.innerText.trim();
            let subjectName = fullText.split("(")[0].trim();

            // Add numbering
            selectedSubjects.push(count + ". " + subjectName);
            count++;

            totalFee += parseInt(sub.value);
        }
    });

    if (selectedSubjects.length === 0) {
        alert("Please select at least one subject.");
        return;
    }

    let studentName = document.getElementById("name").value;

    let message =
        "Student Name: " + studentName + "\n\n" +
        "Selected Subjects:\n" + selectedSubjects.join("\n") + "\n\n" +
        "Total Fee: ₹" + totalFee;

    document.getElementById("result").innerText = message;
});