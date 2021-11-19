function onSignIn(googleUser) {
  // Prevent auto sign in
  gapi.auth2.getAuthInstance().disconnect();

  // Create dynamic form
  var form = document.createElement("form");
  form.action = "auth";
  form.method = "POST";

  // Add user name to form
  var profile = googleUser.getBasicProfile();
  var element = document.createElement("input");
  element.type = "hidden";
  element.name = "google-name";
  element.value = profile.getName();
  form.appendChild(element)

  // Submit form to servlet
  document.body.appendChild(form);
  form.submit();
}
