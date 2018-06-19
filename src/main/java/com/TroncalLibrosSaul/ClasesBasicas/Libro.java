package com.TroncalLibrosSaul.ClasesBasicas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@Table(name="libro")
@NamedQuery(name="libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="autor")
	private String autor;

	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="titulo")
	private String titulo;

	public Libro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}