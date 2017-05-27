/*
 * The MIT License
 *
 * Copyright 2017 Depurador.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sea.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Depurador
 */
@Entity
@Table(name = "tbl_subpagina")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Subpagina.findAll", query = "SELECT s FROM Subpagina s")
	, @NamedQuery(name = "Subpagina.findByIdSubpagina", query = "SELECT s FROM Subpagina s WHERE s.idSubpagina = :idSubpagina")
	, @NamedQuery(name = "Subpagina.findByUrl", query = "SELECT s FROM Subpagina s WHERE s.url = :url")})
public class Subpagina implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUBPAGINA")
	private Integer idSubpagina;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "URL")
	private String url;
	@JoinColumn(name = "TBL_PAGINA_ID_PAGINA", referencedColumnName = "ID_PAGINA")
    @ManyToOne(optional = false)
	private Pagina tblPaginaIdPagina;

	public Subpagina() {
	}

	public Subpagina(Integer idSubpagina) {
		this.idSubpagina = idSubpagina;
	}

	public Subpagina(Integer idSubpagina, String url) {
		this.idSubpagina = idSubpagina;
		this.url = url;
	}

	public Integer getIdSubpagina() {
		return idSubpagina;
	}

	public void setIdSubpagina(Integer idSubpagina) {
		this.idSubpagina = idSubpagina;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Pagina getTblPaginaIdPagina() {
		return tblPaginaIdPagina;
	}

	public void setTblPaginaIdPagina(Pagina tblPaginaIdPagina) {
		this.tblPaginaIdPagina = tblPaginaIdPagina;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idSubpagina != null ? idSubpagina.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Subpagina)) {
			return false;
		}
		Subpagina other = (Subpagina) object;
		if ((this.idSubpagina == null && other.idSubpagina != null) || (this.idSubpagina != null && !this.idSubpagina.equals(other.idSubpagina))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sea.backend.entities.Subpagina[ idSubpagina=" + idSubpagina + " ]";
	}
	
}
