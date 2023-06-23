pw.println("function validate() {");
pw.println("const amountInput = document.getElementById('amount')");
pw.println("const amount = amountInput.value");
pw.println("if (/^\d+(\.\d(0-9){2})?$/.test(amount)) {");
pw.println("} else {");
pw.println("alert('Please enter a valid amount with up to two decimal places')");
pw.println("}");
pw.println("}");