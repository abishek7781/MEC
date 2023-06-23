const form = document.querySelector('form');
const amountInput = document.getElementById('amount');

function validateAmount() {
  const amount = amountInput.value;
  const pattern = /^\d+(\.\d{2})?$/;

  if (!pattern.test(amount)) {
    amountInput.setCustomValidity('Please enter a valid amount with up to two decimal places');
  } else {
    amountInput.setCustomValidity('');
  }
}

function validate() {
const amountInput = document.getElementById('amount');
const amount = amountInput.value;
if (/^\d+(\.\d(0-9){2})?$/.test(amount)) {
} else {
alert('Please enter a valid amount with up to two decimal places');
}
}

function handleSubmit(event) {
  event.preventDefault();
  if (form.checkValidity()) {
    const amount = amountInput.value;
    alert(`Amount entered: ${amount}`);
    // Code to submit form data to server goes here
  } else {
    validateAmount();
  }
}
 
amountInput.addEventListener('input', validateAmount);
form.addEventListener('submit', handleSubmit);
