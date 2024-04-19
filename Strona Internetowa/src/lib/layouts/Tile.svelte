<script>
	let tilesContainer = document.getElementById('tiles-container');
	
	function addTile(title, description, data) {
	  let tile = document.createElement('div');
	  tile.classList.add('tile');
	  
	  tile.innerHTML = `
		<div>
		  <img src="" alt="fota">
		  <div class="title"><b>${title}</b></div>
		  <div class="description">${description}</div>
		  <div class="date">${data}</div>
		</div>
	  `;
	  
	  tilesContainer.appendChild(tile);
	}
  </script>
  
  <div id="tiles-container"></div>
  
  <button onclick="addTile('New Title', 'New Description', 'New Data')">Dodaj kafelek</button>
  