package model;

public class CalendrierAnnuel {
	private Mois[] calendrier = { new Mois("Janvier", 31), new Mois("Fevrier", 28), new Mois("Mars",31),
			new Mois("Avril", 30), new Mois("Mai", 31), new Mois("Juin", 30), new Mois("Juillet", 31),
			new Mois("Aout", 31), new Mois("Septembre", 30), new Mois("Octobre", 31), new Mois("Novembre", 30),
			new Mois("Decembre", 31) };

	public CalendrierAnnuel() {
	}

	private static class Mois {
		private String nom;
		private boolean[] jours;

		public Mois(String nom, int nbJour) {
			this.nom = nom;
			this.jours = new boolean[nbJour];
		}

		public boolean estLibre(int jour) {
			return !jours[jour-1];
		}

		public void reserver(int jour) throws IllegalStateException {
			if (!estLibre(jour)) {
				throw new IllegalStateException("IllegalStateException");
			}
			jours[jour-1] = true;
		}

	}

	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour);
	}

	public boolean reserver(int jour, int mois) {
		if (calendrier[mois-1].estLibre(jour)) {
			calendrier[mois-1].reserver(jour);
			return true;
		} else {
			return false;
		}
	}

}
