<script>
                        function sendMessageToJava(message) {
                            ipc.receiveMessage(JSON.stringify(message));
                        }

                        function clickAndPreventPropagationHandler(e, message) {
                            e.preventDefault();
                            e.stopPropagation();
                            clickHandler(message);
                        }
</script>
<script>
    document.addEventListener('ipcReady', () => {
                   window.ipc.onDocumentReady();
      });
</script>
<script>
    function waitForElementById(id) {
      const observer = new MutationObserver((mutations, obs) => {
        const element = document.getElementById(id);
        if (element) {
          ipc.onElementReady(id);
          obs.disconnect();
        }
      });

      observer.observe(document.body, { childList: true, subtree: true });
    }

  </script>